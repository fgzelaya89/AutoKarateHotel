package model.responseSOAP;

public class MotivoDispDto {
    private String motdisp="";

    public String getMotdisp() {
        return motdisp;
    }

    public void setMotdisp(String motdisp) {
        this.motdisp = motdisp;
    }

    public MotivoDispDto(String motdisp) {
        this.motdisp = motdisp;
    }

    public MotivoDispDto() {
    }

    @Override
    public String toString() {
        return "MotivoDispDto{" +
                "motdisp='" + motdisp + '\'' +
                '}';
    }
}
