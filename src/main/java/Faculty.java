/**
 * Created by mohammad on 5/17/17.
 */
public class Faculty implements FacultyServices {

    private VahedSelectionService vahedSelectionService = new VahedSelectionService();

    public VahedSelectionService getVahedSelectionService() {
        return vahedSelectionService;
    }
}
