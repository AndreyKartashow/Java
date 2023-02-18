package HomeWork14.model.toyModel;

public class Toy extends AbstractToy {
    protected int idToy;
    protected String type;

    public Toy (int idToy, String nameToy, String descriptionToy, double priceToy, int countToy) {
        super(nameToy, descriptionToy, priceToy, countToy);
        this.idToy = idToy;
        this.type = "Не определен";
    }
}
