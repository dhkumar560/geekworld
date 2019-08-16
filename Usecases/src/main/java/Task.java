import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task extends AggregateRoot {
    private String uuid;
    private Long version;
    private String description;
    private String team;
    private String assignee;
    private boolean read;
    private boolean active;
    public Task(String name,String uuid,Long version,String description,String team,String assignee, boolean read,boolean active){
        this(uuid,version,description,team,assignee,read,active);
        super.setName(name);
    }
}
