// package be.ros.spring_panier_exo.configs.jwt;

// import static be.ros.spring_panier_exo.configs.SecurityConst.EXPIRATION_TIME;
// import static be.ros.spring_panier_exo.configs.SecurityConst.HEADER_KEY;
// import static be.ros.spring_panier_exo.configs.SecurityConst.JWT_KEY;
// import static be.ros.spring_panier_exo.configs.SecurityConst.TOKEN_PREFIX;

// import java.util.Date;

// import javax.servlet.http.HttpServletRequest;

// import com.auth0.jwt.JWT;
// import com.auth0.jwt.algorithms.Algorithm;
// import com.auth0.jwt.exceptions.JWTVerificationException;
// import com.auth0.jwt.interfaces.DecodedJWT;
// import be.ros.spring_panier_exo.models.entities.User;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.stereotype.Component;

// @Component
// public class JwtTokenProvider {
//     private final UserDetailsService service;

//     public JwtTokenProvider(UserDetailsService service)
//     {
//         this.service = service;
//     }

//     public String createToken(User user)
//     {
//         return TOKEN_PREFIX + JWT.create()
//             .withSubject(user.getUsername())
//             .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//             .withClaim("roles", user.getRoles())
//             .sign(Algorithm.HMAC512(JWT_KEY));
//     }

//     public String resolveToken(HttpServletRequest request)
//     {
//         String token = request.getHeader(HEADER_KEY);

//         if(token != null && token.startsWith(TOKEN_PREFIX))
//         {
//             // Bearer TOKEN
//             // =>
//             // TOKEN
//             return token.substring(TOKEN_PREFIX.length());
//         }

//         return null;
//     }

//     public boolean validateToken(String token)
//     {
//         try
//         {
//             DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(JWT_KEY))
//                 .build()
//                 .verify(token.replace(TOKEN_PREFIX, ""));

//             String username = decodedJWT.getSubject();
//             Date exp = decodedJWT.getExpiresAt();

//             return username != null && exp != null && exp.after(new Date(System.currentTimeMillis()));
//         }
//         catch(JWTVerificationException e)
//         {
//             return false;
//         }
//     }

//     public Authentication gAuthentication(String token)
//     {
//         String username = JWT.decode(token.replace(TOKEN_PREFIX, "")).getSubject();
//         UserDetails userdetails = service.loadUserByUsername(username);
//         return new UsernamePasswordAuthenticationToken(userdetails.getUsername(), null, userdetails.getAuthorities());
//     }
// }
