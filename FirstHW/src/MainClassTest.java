import org.junit.Test;

public class MainClassTest extends MainClass {

    @Test
    public void testGetLocalNumber() {
        int pr = this.getLocalNumber();
        if( pr == 14) {
            System.out.println("Correct LocalNumber=" + pr);
        } else {
            System.out.println("Incorrect LocalNumber=" + pr);
        }
    }

    @Test
    public void testGetClassNumber() {
        int multiply = this.getClassNumber();
        if ( multiply > 45) {
            System.out.println("Condition is true, classNumber=" + multiply);
        } else {
            System.out.println("Condition is false, classNumber=" + multiply);
        }
    }

    @Test
    public void testGetClassString() {
        String hw = this.getClassString();

        if(hw.contains("hello") || hw.contains("Hello")){
            System.out.println("Word 'Hello' is find");
        } else if(hw.contains(null)) {
            System.out.println("Word 'Hello' is notfind");
        }

    }
}
