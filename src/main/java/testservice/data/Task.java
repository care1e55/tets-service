package testservice.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Task {

	private String id;
	private String timestamp;
	private String status;

	public Task(String id, String timestamp, String status) {
		this.id = id;
		this.timestamp = timestamp;
		this.status = status;
	}

}
