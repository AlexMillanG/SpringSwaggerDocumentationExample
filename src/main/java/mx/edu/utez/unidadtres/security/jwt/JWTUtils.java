package mx.edu.utez.unidadtres.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

//CUARTO PASO:
@Service
public class JWTUtils {

    @Value("${secret.key}")
    private String SECRET_KEY;

    //extrae todo las cosas del fakin token
    //body, headers,
    public Claims extractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY) //desencripta con la llave secrete
                .parseClaimsJws(token)//parsea el cuerpo del token
                .getBody();//obtiene el cuerpo del token
    }

    //extrae las propiedades del token
    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
    final Claims CLAIMS = extractAllClaims(token);
    return claimsResolver.apply(CLAIMS);
    }

    public String extractUsername(String token){
        return  extractClaim(token,Claims::getSubject);
    }

    public Date extractExpirationDate(String token){
        return extractClaim(token,Claims::getExpiration);
    }
}
