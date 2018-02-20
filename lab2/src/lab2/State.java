package lab2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "comment")
public class State
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int state_id;

    private String abbreviation;

    private String name;
    

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "comment_id")
    protected int getState_id()
    {
        return state_id;
    }

    protected void setState_id(int state_id)
    {
        this.state_id = state_id;
    }

    protected String getName()
    {
        return name;
    }

    protected void setName(String name)
    {
        this.name = name;
    }

    protected String getAbbreviation()
    {
        return abbreviation;
    }

    protected void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    
}
