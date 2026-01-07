package pl.tomkan.api25.version;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Slf4j
@RestController
@Tag(name = "Version", description = "Application version API")
@CrossOrigin
public class VersionControlller {

    @Operation(summary = "Get application version", description = "Returns the current application version")
    @GetMapping("/version")
    VersionResponse getVersion(@RequestParam(required = false, defaultValue = "0") Integer delay) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(delay));
        return new VersionResponse("2.5", "" + LocalDateTime.now());
    }
}
