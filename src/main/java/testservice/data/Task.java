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

	private UUID id;
	private LocalDateTime timestamp;
	private String status;

	public Task(UUID id, LocalDateTime timestamp, String status) {
		this.id = id;
		this.timestamp = timestamp;
		this.status = status;
	}

}
