
package springTest.aop;

public class ShowImpl implements Show {

    @Override
    public void add() {
        System.out.println("Enter DaoImpl.adds()");
    }
}