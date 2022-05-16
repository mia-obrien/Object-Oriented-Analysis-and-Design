/**
 * HW04
 * @author Mihriban Güneydaş
 * Student Number:151044096
 */

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
interface State 
{
    /**
     * Bu fonksiyon state lerde olan işlemleri gösterir
     * @param context 
     */
   public void doAction(Context context);
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Ready implements State 
{
   
    private String info;
    public Ready() 
    {}
    /**
     * 
     * @param info parametresi durum değişmesindeki actionları belirtir; exercise,cheating gibi
     */
    public Ready(String info) 
    {
        this.info = info;
    }
    
    @Override
    public void doAction(Context context) 
        {
            System.out.println("Player is in "+this);

            context.setState(this);	
            if(info.equals("perverance"))
            {
                System.out.println("Action : Perverance and Hard Work");
                context.setState(new Graduate());
            } 
            else if(info.equals("exercise"))
            {
                System.out.println("Action : Exercise");
                context.setState(new Fit(""));
            }
            else if(info.equals("cheating"))
            {
                System.out.println("Action : Cheating");
                context.setState(new Unable());
            }
            else if(info.equals("buying"))
            {
                System.out.println("Action : Buying a GTX1080");
                context.setState(new Unable());
            }
            else if(info.equals("out"))
            {
                System.out.println("Action : Out Till Late");
                context.setState(new NeedingSleep());
            }
    }
    @Override
    public String toString()
    {
      return "Ready State";
    }
     
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Graduate implements State 
{
    public Graduate() 
    {}
    @Override
    public void doAction(Context context) 
    {
      System.out.println("Player is in "+this);
      context.setState(this);	
    }
    
    @Override
    public String toString()
    {
      return "Graduate State";
    }

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Fit implements State 
{
    private String info;
    public Fit() 
    {}
    /**
     * 
     * @param info parametresi durum değişmesindeki actionları belirtir; exercise,cheating gibi
     */
    public Fit(String info) 
    {
        this.info = info;
    }
    @Override
    public void doAction(Context context) 
    {
        System.out.println("Player is in "+this);

        context.setState(this);	
        if(info.equals("perverance"))
        {
            System.out.println("Action : Perverance and Hard Work");
            context.setState(new Graduate());
        } 	
    }
    @Override
    public String toString()
    {
      return "Fit State";
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Unable implements State 
{
    public Unable() 
    {}
    @Override
    public void doAction(Context context) 
    {
      System.out.println("Player is in "+this);
      context.setState(this);	
    }
    @Override
    public String toString()
    {
      return "Unable State";
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class NeedingSleep implements State 
{
    private String info;
    public NeedingSleep() 
    {}
    /**
     * 
     * @param info parametresi durum değişmesindeki actionları belirtir; exercise,cheating gibi
     */
    public NeedingSleep(String info) 
    {
        this.info = info;
    }
    @Override
    public void doAction(Context context) 
    {
        System.out.println("Player is in "+this);

        context.setState(this);	
        if(info.equals("sleep"))
        {
            System.out.println("Action : Sleep");
            context.setState(new Ready());
        }
        else if(info.equals("coffee"))
        {
            System.out.println("Action : Coffee and Work");
            context.setState(new ChronicIllness());
        } 
    }
    @Override
    public String toString()
    {
      return "Needing Sleep State";
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class ChronicIllness implements State 
{
    public ChronicIllness() 
    {}
    @Override
    public void doAction(Context context) 
    {
      System.out.println("Player is in "+this);
      context.setState(this);	
    }
    @Override
    public String toString()
    {
      return "Chronic Illness State";
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


class Context 
{
    private State state;
    public Context() 
    {
        state = null;
    }
    /**
     * 
     * @param state kendine olan state i atar
     */
    public void setState(State state) 
    {
        this.state = state;
    }
    /**
     * 
     * @return son state i döndürür
     */
    public State getState()
    {
      return state;
    }

}

public class Test 
{

    public static void main(String[] args) 
    {
        Context context = new Context();

        Ready obj = new Ready("perverance");
        obj.doAction(context);
        System.out.println("Player is in "+context.getState().toString());
        System.out.println("------------------------------------------------");

        obj = new Ready("exercise");
        obj.doAction(context);
        System.out.println("Player is in "+context.getState().toString());
        System.out.println("------------------------------------------------");

        Fit obj2 = new Fit("perverance");
        obj2.doAction(context);
        System.out.println("Player is in "+context.getState().toString());
        
        System.out.println("------------------------------------------------");
        obj = new Ready("cheating");
        obj.doAction(context);
        System.out.println("Player is in "+context.getState().toString());
        
        System.out.println("------------------------------------------------");
        obj = new Ready("buying");
        obj.doAction(context);
        System.out.println("Player is in "+context.getState().toString());
        
        System.out.println("------------------------------------------------");
        obj = new Ready("out");
        obj.doAction(context);
        System.out.println("Player is in "+context.getState().toString());
        
        System.out.println("------------------------------------------------");
        NeedingSleep obj6 = new NeedingSleep("coffee");
        obj6.doAction(context);
        System.out.println("Player is in "+context.getState().toString());
        
        System.out.println("------------------------------------------------");
        obj6 = new NeedingSleep("sleep");
        obj6.doAction(context);
        System.out.println("Player is in "+context.getState().toString());
        
    }
}
