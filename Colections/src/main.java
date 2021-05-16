import java.util.ArrayList;
import java.util.List;





public class main {
		public static void main(String[] args) {
			
			List<String> obj  = new ArrayList<>();
			
			obj.add("A");
			obj.add("b");

			obj.add("c");
			
			obj.add("c");

			obj.add("d");
			
			System.out.println(obj.remove("c"));
			System.out.println(obj);

		}
}
