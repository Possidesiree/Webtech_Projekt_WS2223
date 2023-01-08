package htw.berlin.webtech.Webtech.benutzerKonto;

import htw.berlin.webtech.Webtech.registration.token.ConfirmationTokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BenutzerKontoService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    private final BenutzerKontoRepository benutzerKontoRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public BenutzerKontoService(
            BenutzerKontoRepository benutzerKontoRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            ConfirmationTokenService confirmationTokenService) {
        this.benutzerKontoRepository = benutzerKontoRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }


    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return benutzerKontoRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public BenutzerKonto signUpUser(BenutzerKonto benutzerKonto) {
        boolean userExists = benutzerKontoRepository
                .findByEmail(benutzerKonto.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(benutzerKonto.getPassword());

        benutzerKonto.setPassword(encodedPassword);
        benutzerKonto.setEnabled(true);
        return benutzerKontoRepository.save(benutzerKonto);

        /*String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                benutzerKonto
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

//        TODO: SEND EMAIL

        return token;*/
    }

    public int enableAppUser(String email) {
        return benutzerKontoRepository.enableAppUser(email);
    }
}
