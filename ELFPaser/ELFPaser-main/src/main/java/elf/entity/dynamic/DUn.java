package elf.entity.dynamic;

/**
 * @author qxm
 * @create 2022-07-09 8:55
 **/
public class DUn {
    private Integer d_val;
    private Integer d_ptr;

    public DUn(int d_val, int d_ptr) {
        this.d_val = d_val;
        this.d_ptr = d_ptr;
    }

    public DUn() {
    }

    public Integer getD_val() {
        return d_val;
    }

    public void setD_val(Integer d_val) {
        this.d_val = d_val;
    }

    public Integer getD_ptr() {
        return d_ptr;
    }

    public void setD_ptr(Integer d_ptr) {
        this.d_ptr = d_ptr;
    }

    @Override
    public String toString() {
        return "DUn{" +
                "d_val=" + d_val +
                ", d_ptr=" + d_ptr +
                '}';
    }
}
