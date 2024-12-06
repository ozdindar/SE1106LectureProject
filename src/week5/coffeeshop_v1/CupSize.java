package week5.coffeeshop_v1;

public enum CupSize {
    Small, Medium,Large;

    double toPriceCoefficient()
    {
        switch (this)
        {
            case Small : return 1.0;
            case Medium: return  1.5;
            case Large :return 2.0;
            default:return  2.0;
        }
    }

    String toCode()
    {
        switch (this)
        {
            case Small : return "S";
            case Medium: return  "M";
            case Large :return "L";
            default:return  "L";
        }
    }
}
