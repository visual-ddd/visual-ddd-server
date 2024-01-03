package com.wakedt.visual.start.config;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedata.common.spring.exception.GlobalExceptionHandler;
import com.wakedt.visual.domain.common.constant.VisualException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 项目异常处理器
 *
 * @author ZhuXueLiang
 * @version 1.0
 */
@Slf4j
@RestControllerAdvice
public class ProjectExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler({VisualException.class})
    public ResultDTO<?> exceptionHandler(HttpServletRequest request, VisualException ex) {
        log.error("sys error, message={}", ex.getMessage(), ex);
        return ResultDTO.fail(ex.getCode(), this.getI18nMessage(request, ex.getMessage()));
    }
}