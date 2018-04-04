package restFramework.com.rest.requestpojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreatePerson {

@SerializedName("name")
@Expose
private String name;
@SerializedName("job")
@Expose
private String job;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getJob() {
return job;
}

public void setJob(String job) {
this.job = job;
}

}