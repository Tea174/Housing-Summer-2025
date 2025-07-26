package belgium.antwerp.housing.domain.exception;

public class NotFoundException extends RuntimeException {
    private NotFoundException (final String message) {
        super(message);
    }
    public static NotFoundException forHouse(final int houseId){
        return new NotFoundException("House with id " + houseId + " not found");
    }
    public static NotFoundException forAppUser(final int appUserId){
        return new NotFoundException("AppUser with id " + appUserId + " not found");
    }

}
