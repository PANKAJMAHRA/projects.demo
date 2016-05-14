import com.hydra.util.Database;

public class Test {

	public static void main(String[] args) {
		if(Database.getConnection()!=null)
		{
			System.out.println("okay");
		}
		else
		{
			System.out.println("not okay");
		}

	}

}
