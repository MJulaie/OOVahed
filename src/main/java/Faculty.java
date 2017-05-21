/**
 * Created by mohammad on 5/17/17.
 */
public class Faculty implements FacultyServices {

    private VahedSelectionService vahedSelectionService = new VahedSelectionService();
    private GraduationService graduationService = new GraduationService();

    public VahedSelectionService getVahedSelectionService() {
        return vahedSelectionService;
    }

    public GraduationService getGraduationService() {
        return graduationService;
    }
}
