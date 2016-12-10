package Manufacturers;

public class Manufacturer {

    private String _name, _description;

    public Manufacturer(String name, String description) {
        this._name = name;
        this._description = description;
    }

    //accessors
    public String getName() {
        return _name;
    }

    public String getDescription() {
        return _description;
    }

    //mutators
    public void setName(String _name) {
        this._name = _name;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

}
