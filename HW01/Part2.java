/**
 * Homework01 - Part2 
 * @author Mihriban Güneydaş
 * Student Number:151044096
 */

interface Type 
{
    
    void calculate();
}
class dec implements Type 
{
   int price = 500000;
   double weight = 25;
   
   @Override
   public void calculate() 
   {
      System.out.println("Price: "+ price + " TL" +"\n" + "Weight: " + weight + " kg" + "\n");
   }
}
class orac implements Type 
{
   int price = 1500000;
   double weight = 30;
   
   @Override
   public void calculate() 
   {
      System.out.println("Price: "+ price + " TL" +"\n" + "Weight: " + weight + " kg" + "\n");
   }
}
class tor implements Type 
{
   int price = 5000000;
   double weight = 50;
   
   @Override
   public void calculate() 
   {
      System.out.println("Price: "+ price + " TL" +"\n" + "Weight: " + weight + " kg" + "\n" );
   }
}
abstract class TypeDecorator implements Type 
{
   protected Type added;

   public TypeDecorator(Type added)
   {
      this.added = added;
   }

   @Override
   public void calculate()
   {
      added.calculate();
   }	
}

class FlamethrowerDecorator extends TypeDecorator 
{
    public FlamethrowerDecorator(Type added) 
    {
        super(added);
    }

    @Override
    public void calculate() 
    {
        
        added.calculate();	       
        setFlamethrower(added);
    }
    
   private void setFlamethrower(Type added)
   {
      System.out.println("Price: 550000 TL" +"\n" + "Weight: 27 kg" + "\n");
   }
   
}
class AutoRifleDecorator extends TypeDecorator 
{

    public AutoRifleDecorator(Type added) 
    {
        super(added);
    }

    @Override
    public void calculate() 
    {
      
       added.calculate();	       
       setAutoRifle(added);
    }

    private void setAutoRifle(Type added)
    {
        System.out.println(added);
    } 
}
class RocketLauncherDecorator extends TypeDecorator 
{

    public RocketLauncherDecorator(Type added) 
    {
        super(added);
    }

    @Override
    public void calculate() 
    {
       added.calculate();	       
       setRocketLauncher(added);
    }

    private void setRocketLauncher(Type added)
    {
        System.out.println(added);
    }
   
}
class LaserDecorator extends TypeDecorator 
{
    public LaserDecorator(Type added) 
    {
        super(added);
    }

    @Override
    public void calculate() 
    {
       
       added.calculate();	       
       setLaser(added);
    }

    private void setLaser(Type added)
    {
        System.out.println(added);
    }    
   
}

/**
 *
 * @author mihriban
 */
public class JavaApplication23 
{

    /**
     *
     * @param args
     */
    public static void main(String[] args) 
    {
        Type obj1 = new dec();
        Type obj2 = new orac();
        Type obj3 = new tor();
        
        obj1.calculate();
        obj2.calculate();
        obj3.calculate();
        
        Type obj4 = new FlamethrowerDecorator(new dec());
        /*Type obj5 = new AutoRifleDecorator(new orac());
        Type obj6 = new RocketLauncherDecorator(new tor());
        Type obj7 = new LaserDecorator(new dec());*/
        
        System.out.println("The new price of the dec is");
        obj4.calculate();

    }
    
}
