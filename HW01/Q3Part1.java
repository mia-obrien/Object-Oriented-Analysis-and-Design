
/**
 * Homework01 - Part3 - First Question
 * @author Mihriban Güneydaş
 * Student Number:151044096
 */

abstract class PlaneFactory
{
    public Plane productPlane(String type) 
    { 
        Plane plane = null;
        plane.constructSkeleton(); 
        plane.placeEngines(); 
        plane.placeSeats(); 
      
        return plane; 
    }
    //use getShape method to get object of type shape 
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
   
}

abstract class Plane
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

class FactoryMethod
{
    public static void main(String[] args) 
    {
        PlaneFactory planeFactory = new PlaneFactory() {};
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
        
    }  
}
