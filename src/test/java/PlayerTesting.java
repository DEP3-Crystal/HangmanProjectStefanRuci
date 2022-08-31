import model.Player;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTesting {
    @Test
    public void setName(){
        Player player =new Player();

         String expected="stefan" ;
         player.name="stefan";
        Assert.assertEquals(expected,player.name);
    }
}
