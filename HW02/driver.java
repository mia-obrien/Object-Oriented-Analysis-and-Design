/**
 * HW02
 * @author Mihriban Güneydaş
 * Student Number:151044096
 */


interface ModernPayment
{
    /**
     * pay metodu ödemeler hakkında bilgi verir
     * @param cardNo kartın herkeste tek olan özel numarası
     * @param amount kartın bakiyesi
     * @param destination gidilecek yer
     * @param installments güncellemeler
     * @return  bakiye döndürür
     */
    int pay(String cardNo,  float amount, String destination, String installments); 
}

interface TurboPayment
{
    /**
     * payInTurbo metodu ödemeler hakkında bilgi verir ama binary bir şekilde
     * @param turboCardNo kartın herkeste tek olan özel numarası
     * @param turboAmount kartın bakiyesi
     * @param destinationTurboOfCourse gidilecek yer
     * @param installmentsButInTurbo güncellemeler
     * @return  bakiye döndürür
     */
    int payInTurbo(String turboCardNo,  float turboAmount,String destinationTurboOfCourse, String installmentsButInTurbo);
}

class Turbo implements TurboPayment
{ 
    @Override
    public int payInTurbo(String turboCardNo,  float turboAmount,String destinationTurboOfCourse, String installmentsButInTurbo)
    {
        System.out.println("Turbo Card No = "+turboCardNo);
        System.out.println("Turbo Amount = "+turboAmount);
        System.out.println("Destination = "+destinationTurboOfCourse);
        System.out.println("Installments = "+installmentsButInTurbo);
        
        return (int) turboAmount;
    }
}

class ModernAdapter implements TurboPayment
{ 
    ModernPayment modernPayment;
    /**
     * Bu metod adaptör metodumuzdur
     * @param modernPayment 
     */
    public ModernAdapter(ModernPayment modernPayment) 
    {
        this.modernPayment = modernPayment; 
    }
    @Override
    public int payInTurbo(String turboCardNo,  float turboAmount,String destinationTurboOfCourse, String installmentsButInTurbo)
    {
        modernPayment.pay();
        return 0;
    }
}

class Modern implements ModernPayment
{ 
    @Override
    public int pay(String cardNo,  float amount, String destination, String installments) 
    {
        System.out.println("Card No = "+cardNo);
        System.out.println("Amount = "+amount);
        System.out.println("Destination = "+destination);
        System.out.println("Installments = "+installments);
        
        return (int) amount;
    }
}

public class Test
{
    public static void main(String[] args) 
    {
        Turbo obj1 = new Turbo();
        Modern obj2 = new Modern();
        TurboPayment obj3 = new ModernAdapter(obj2);
        obj1.payInTurbo("1010", 1001101, "1001", "0000\n");
        obj2.pay("1789", 123, "Istanbul", "1239\n");
        
    }
}
