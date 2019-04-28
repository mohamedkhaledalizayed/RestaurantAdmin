package smile.algeria.khadamet.restaurantadmin.views.interfaces;

public interface IOrdersHandler {
    void onCallClicked(String number);
    void onViewDetailsClicked(String id,int type);
    void onCancelClicked();
    void onAcceptClicked();
    void onDeliveryClicked();

}
