package HomeWork14.model.toyModel;

public class SoftToy extends Toy {

     public SoftToy(int idToy, String nameToy, String descriptionToy, double priceToy, int countToy) {
         super(idToy, nameToy, descriptionToy, priceToy, countToy);
         this.type = "Мягкая игрушка";
    }
}
