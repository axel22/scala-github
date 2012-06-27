





public class Test {
    
    public void mustBeAbleToForeachAFuture() throws Throwable {
	new Foreach<String>() {
		public void each(String future) {
		}
	    };
    }
    
}