package HomeWork14.botService;

public class Customer {
    String m_name_customer;
    String f_name_customer;
    String l_name_customer;

    public Customer(String m_name_customer, String f_name_customer, String l_name_customer) {
        this.m_name_customer = m_name_customer;
        this.f_name_customer = f_name_customer;
        this.l_name_customer = l_name_customer;
    }

    public String getMname() {
        return m_name_customer;
    }

    public String getFname() {
        return f_name_customer;
    }

    public String getLname() {
        return l_name_customer;
    }
}
