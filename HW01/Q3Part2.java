/**
 * Homework01 - Part3 - Second Question
 * @author Mihriban Güneydaş
 * Student Number:151044096
 */
abstract class AbstractFactory 
{
   abstract Plane getPlane(String plane);
   abstract BigMarket getBigMarket(String bigMarket);
}
class PlaneFactory extends AbstractFactory
{
    public Plane productPlane(String type) 
    { 
        Plane plane = null;
        plane.constructSkeleton(); 
        plane.placeEngines(); 
        plane.placeSeats(); 
      
        return plane; 
    }
    
    @Override
    public Plane getPlane(String planeType)
    {
        if(planeType == null)
        {
            return null;
        }		
        if(planeType.equalsIgnoreCase("TPX100"))
        {
            return new TPX100();
        } 
        else if(planeType.equalsIgnoreCase("TPX200"))
        {
            return new TPX200();
        } 
        else if(planeType.equalsIgnoreCase("TPX300"))
        {
            return new TPX300();
        }
        return null;
     
   }
    @Override
    BigMarket getBigMarket(String bigMarket)
    {
        return null;
    }
   
}
class BigMarketFactory extends AbstractFactory
{
    
    
    @Override
    public BigMarket getBigMarket(String bigMarket)
    {
        if(bigMarket == null)
        {
            return null;
        }		
        if(bigMarket.equalsIgnoreCase("Domestic"))
        {
            return new Domestic();
        } 
        else if(bigMarket.equalsIgnoreCase("Eurasia"))
        {
            return new Eurasia();
        } 
        else if(bigMarket.equalsIgnoreCase("Other"))
        {
            return new Other();
        }
      
        return null;
   }
    @Override
    Plane getPlane(String plane)
    {
        return null;
    }
   
}
class Plane
{ 
    String model;
    String purpose;
    String skeleton;
    String engine;
    int seating;
    
    void constructSkeleton() 
    {
        System.out.println("Plane model is " + model); 
        System.out.println("Plane purpose is " + purpose); 
        System.out.println("Plane skeleton is " + skeleton);   
    }
    void placeEngines() 
    { 
        System.out.println("Plane engine is " + engine); 
    }
    void placeSeats() 
    { 
        System.out.println("Plane's seatings is " + seating  +"\n");     
    }
   
    public String getName() 
    {
        return model; 
    }
}

class TPX100 extends Plane
{
    public TPX100() 
    {
        model = "TPX100"; 
        purpose = "Domestic flights";
        skeleton = "Aluminium alloy";
        engine = "Single jet engine";
        seating = 50;
    }
}
class TPX200 extends Plane
{
    public TPX200() 
    {
        model = "TPX200"; 
        purpose = "Domestic and short international flights";
        skeleton = "Nickel alloy";
        engine = "Twin jet engines";
        seating = 100;
    }
}
class TPX300 extends Plane
{
    public TPX300() 
    {
        model = "TPX300"; 
        purpose = "Transatlantic flights";
        skeleton = "Titanium alloy";
        engine = "Quadro jet engines";
        seating = 250;
    }
}


class BigMarket
{ 
    String market;
    String injection;
    String cover;
    
    void printInfo() 
    {
        System.out.println("Market is " + market); 
        System.out.println("Engine injection type is " + injection); 
        System.out.println("Seating cover is " + cover);   
    }
    
    public String getName() 
    {
        return market; 
    }
    
}

class Domestic extends BigMarket
{
    public Domestic() 
    {
        market = "Domestic"; 
        injection = "Turbojet";
        cover = "Velvet";
    }
}
class Eurasia extends BigMarket
{
    public Eurasia() 
    {
        market = "Eurasia"; 
        injection = "Turbofan";
        cover = "Linen";
    }

}
class Other extends BigMarket
{
    public Other() 
    {
        market = "Other"; 
        injection = "Geared turbofan";
        cover = "Leather";
    }

}

class FactoryProducer 
{
   public static AbstractFactory getFactory(String choice)
   {
   
        if(choice.equalsIgnoreCase("PLANE"))
        {
            return new PlaneFactory();
        }
        else if(choice.equalsIgnoreCase("BIGMARKET"))
        {
            return new BigMarketFactory();
        }
      
      return null;
   }
}

/**
 *
 * @author mihriban
 */
public class Test
{

    /**
     *
     * @param args
     */
    public static void main(String[] args) 
    {
        AbstractFactory planeFactory = FactoryProducer.getFactory("PLANE");
        Plane obj1 = planeFactory.getPlane("TPX100");
        obj1.constructSkeleton();
        obj1.placeEngines();
        obj1.placeSeats();
      
        Plane obj2 = planeFactory.getPlane("TPX200");
        obj2.constructSkeleton();
        obj2.placeEngines();
        obj2.placeSeats();
        
        Plane obj3 = planeFactory.getPlane("TPX300");
        obj3.constructSkeleton();
        obj3.placeEngines();
        obj3.placeSeats();
      
        AbstractFactory BigMarketFactory = FactoryProducer.getFactory("BIGMARKET");
        BigMarket obj4 = BigMarketFactory.getBigMarket("Domestic");
        obj4.printInfo();
        
       
    }  
}


