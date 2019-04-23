/**
 * @ClassName AppleFactory
 * @Description TODO
 * @Author L
 * @Date 2019/4/13 14:21
 * @Version 1.0
 **/
public class AppleFactory implements ComputerFactory {

    @Override
    public Computer createComputer() {
        return new MacbookProComputer();
    }

    @Override
    public OperatingSystem createSystem() {
        return new MacOs();
    }
}
