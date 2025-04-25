package kamenov.naturalnaturefinalapp.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kamenov.naturalnaturefinalapp.entity.DailyVisitorCount;
import kamenov.naturalnaturefinalapp.repositories.DailyVisitorCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDate;

@Component
public class VisitorCountFilter extends OncePerRequestFilter {

    @Autowired
    private DailyVisitorCountRepository dailyVisitorCountRepository;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException {
        HttpSession session = request.getSession(true);
        Boolean isNewVisitor = (Boolean) session.getAttribute("isNewVisitor");

        if (isNewVisitor == null || !isNewVisitor) {
            // Маркираме потребителя като нов
            session.setAttribute("isNewVisitor", true);

            // Увеличаваме броя на уникалните посетители за днес
            LocalDate today = LocalDate.now();
            DailyVisitorCount visitorCount = dailyVisitorCountRepository.findByDate(today)
                    .orElse(new DailyVisitorCount(today, 0L));

            visitorCount.setUniqueVisitors(visitorCount.getUniqueVisitors() + 1);
            dailyVisitorCountRepository.save(visitorCount);
        }

        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            throw new RuntimeException("Error in VisitorCountFilter", e);
        }
    }
}
