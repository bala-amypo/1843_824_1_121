@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @Override
    public User register(User user) {
        if (user.getRole() == null) {
            user.setRole("STAFF");
        }

        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new ApiException("User already exists");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new ApiException("User not found"));
    }
}
