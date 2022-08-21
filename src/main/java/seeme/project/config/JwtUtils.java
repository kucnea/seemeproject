package seeme.project.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import seeme.project.config.auth.PrincipalDetails;

import java.util.Date;

@Component
@Slf4j
public class JwtUtils {

    private String jwtSecret = JwtProperties.SECRET;
    private int jwtExpirationMs = JwtProperties.EXPIRATION_TIME;

    public String generateToken(Authentication authentication){
        log.info("generateToken Stage");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();

        return JWT.create()
                .withIssuer(JwtProperties.ISSUER)
                .withSubject(principalDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .withClaim("vId",principalDetails.getUsername())
                .withClaim("vPw",principalDetails.getPassword())
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));
    }

    public String getUserNameFromJwtToken(String jwt){
        log.info("getUserNameFromJwtToken Stage");

        log.info(JWT.decode(jwt).getId());
        log.info(JWT.decode(jwt).getKeyId());
        return jwt;
    }

    public boolean validateJwtToken(String authToken){

        log.info("validateJwtToken Stage");

        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET))
                                        .withIssuer(JwtProperties.ISSUER) //
                                        .acceptExpiresAt(JwtProperties.EXPIRATION_TIME)
                                        .build();

            DecodedJWT jwt = verifier.verify(authToken);
            log.info("========== jwt Token ===========");
            log.info("jwt token         : " + jwt.getToken());
            log.info("jwt algorithm     : " + jwt.getAlgorithm());
            log.info("jwt claims        : " + jwt.getClaims());
            log.info("jwt issuer        : " + jwt.getIssuer());
            log.info("jwt issuer date   : " + jwt.getIssuedAt());
            log.info("jwt expires date  : " + jwt.getExpiresAt());
            log.info("jwt signature     : " + jwt.getSignature());
            log.info("jwt type          : " + jwt.getType());
            log.info("jwt key id        : " + jwt.getKeyId());
            log.info("jwt id            : " + jwt.getId());
            log.info("jwt subject       : " + jwt.getSubject());
            log.info("jwt content type  : " + jwt.getContentType());
            log.info("jwt audience list : " + jwt.getAudience());
            log.info("========== jwt Token ===========");
        }catch (JWTVerificationException e){
            log.debug("Jwt Token verify Error");
            log.debug(e.getMessage());
        }

        return true;
    }

}
