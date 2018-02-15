package rc.domain;

public interface HotelInterface {

    public String getName();

    public int getClassification();

    public long getId();

    public boolean isOpen();

    public void setId(long id);

    public void setName(String name);

    public void setClassification(int classification);

    public void setOpen(boolean open);

}
