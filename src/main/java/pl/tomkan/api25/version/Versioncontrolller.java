package pl.tomkan.api25.version;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RequiredArgsConstructor
@Slf4j
@RestController
@Tag(name = "Version", description = "Application version API")
public class Versioncontrolller {

    @Operation(summary = "Get application version", description = "Returns the current application version")
    @GetMapping("/version")
    public String getVersion(@RequestParam(required = false, defaultValue = "0") Integer delay) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(delay));
        return "2.5";
    }
}
