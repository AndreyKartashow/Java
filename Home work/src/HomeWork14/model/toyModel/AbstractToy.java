package HomeWork14.model.toyModel;

public abstract class AbstractToy {
    String nameToy;
    String descriptionToy;
    double priceToy;
    int countToy;

    public AbstractToy(String nameToy, String descriptionToy, double priceToy, int countToy) {
        this.nameToy = nameToy;
        this.descriptionToy = descriptionToy;
        this.priceToy = priceToy;
        this.countToy = countToy;
    }

    public void setCountToy(int countToy) {
        this.countToy = countToy;
    }
}
