package com.maersk.apawnd.commons.component.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Util for retrieve message resources.
 */
@Component
@Slf4j
public class MessageUtil {

  private final MessageSource messageSource;

  public MessageUtil(
      MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  /**
   * retrieve message resources
   * @param key
   * @return String
   */
  public String get(String key) {
    return this.get(key, null, LocaleContextHolder.getLocale());
  }

  /**
   * retrieve message resources
   * @param key
   * @param objects
   * @return String
   */
  public String get(String key, Object[] objects) {
    return this.get(key, objects, LocaleContextHolder.getLocale());
  }

  /**
   * retrieve message resources
   * @param key
   * @param objects
   * @param locale
   * @return String
   */
  public String get(String key, Object[] objects, Locale locale) {
    return messageSource.getMessage(key, objects, locale);
  }

  /**
   * retrieve message resources code value
   * @param key
   * @return String
   */
  public String getCode(String key) {
    return this.get(
        StringUtils.join(key, MESSAGE_SUFFIX_CODE),
        null,
        LocaleContextHolder.getLocale());
  }

  /**
   * retrieve message resources title value
   * @param key
   * @return String
   */
  public String getTitle(String key) {
    return this.get(
        StringUtils.join(key, MESSAGE_SUFFIX_TITLE),
        null,
        LocaleContextHolder.getLocale());
  }

  /**
   * retrieve message resources title value
   * @param key
   * @param objects
   * @return String
   */
  public String getTitle(String key, Object[] objects) {
    return this.get(
        StringUtils.join(key, MESSAGE_SUFFIX_TITLE),
        objects,
        LocaleContextHolder.getLocale());
  }

  /**
   * retrieve message resources detail value
   * @param key
   * @return String
   */
  public String getDetail(String key) {
    return this.get(
        StringUtils.join(key, MESSAGE_SUFFIX_DETAIL),
        null,
        LocaleContextHolder.getLocale());
  }

  /**
   * retrieve message resources detail value
   * @param key
   * @param objects
   * @return String
   */
  public String getDetail(String key, Object[] objects) {
    return this.get(
        StringUtils.join(key, MESSAGE_SUFFIX_DETAIL),
        objects,
        LocaleContextHolder.getLocale());
  }

  public static final String MESSAGE_SUFFIX_CODE = ".code";
  public static final String MESSAGE_SUFFIX_TITLE = ".title";
  public static final String MESSAGE_SUFFIX_DETAIL = ".detail";
}
