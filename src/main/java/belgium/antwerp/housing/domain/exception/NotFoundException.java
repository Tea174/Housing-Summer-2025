package belgium.antwerp.housing.domain.exception;

public class NotFoundException extends RuntimeException {
    private NotFoundException (final String message) {
        super(message);
    }
    public static NotFoundException forHouse(final int houseId){
        return new NotFoundException("House with id " + houseId + " not found");
    }
    public static NotFoundException forCustomer(final int customerId){
        return new NotFoundException("Customer with id " + customerId + " not found");
    }
    public static NotFoundException forOwner(final int ownerId){
        return new NotFoundException("Owner with id " + ownerId + " not found");
    }
}
