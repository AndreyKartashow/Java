package HomeWork14.model.toyModel;

public class OptionToy implements IOptionToy {

    @Override
    public String getToyInfo(Toy toy) {
        return toy.nameToy + " "
                + "<"+toy.nameToy+">" + " "
                + "-"+toy.descriptionToy+"." + " "
                + "Стоимость - "+toy.priceToy+"$";
    }

    @Override
    public String getNameToy(Toy toy) {
        return toy.nameToy;
    }

    @Override
    public int getCountToy(Toy toy) {
        return toy.countToy;
    }

    @Override
    public int getId(Toy toy) {
        return toy.idToy;
    }


}
