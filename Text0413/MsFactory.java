/**
 * @ClassName MsFactory
 * @Description TODO
 * @Author L
 * @Date 2019/4/13 14:19
 * @Version 1.0
 **/
public class MsFactory implements ComputerFactory{
    @Override
    public Computer createComputer() {
        return new SurfaceBookComputer();
    }

    @Override
    public OperatingSystem createSystem() {
        return new Windows10();
    }


}
