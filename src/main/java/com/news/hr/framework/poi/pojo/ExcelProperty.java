/*
 * Copyright (c) 2018, 吴汶泽 (wenzewoo@gmail.com).
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.news.hr.framework.poi.pojo;

import com.news.hr.framework.poi.config.Options;
import com.news.hr.framework.poi.convert.ReadConverter;
import com.news.hr.framework.poi.convert.WriteConverter;
import com.news.hr.framework.poi.validator.Validator;
import lombok.*;

/**
 * @author wuwenze
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExcelProperty {

  private String name;
  private String column;
  private Boolean required;
  private Short width;
  private String comment;
  private Integer maxLength;
  private String dateFormat;
  private Options options;
  private String writeConverterExp;
  private WriteConverter writeConverter;
  private String readConverterExp;
  private ReadConverter readConverter;
  private String regularExp;
  private String regularExpMessage;
  private Validator validator;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColumn() {
    return column;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public Boolean getRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public Short getWidth() {
    return width;
  }

  public void setWidth(Short width) {
    this.width = width;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Integer getMaxLength() {
    return maxLength;
  }

  public void setMaxLength(Integer maxLength) {
    this.maxLength = maxLength;
  }

  public String getDateFormat() {
    return dateFormat;
  }

  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
  }

  public Options getOptions() {
    return options;
  }

  public void setOptions(Options options) {
    this.options = options;
  }

  public String getWriteConverterExp() {
    return writeConverterExp;
  }

  public void setWriteConverterExp(String writeConverterExp) {
    this.writeConverterExp = writeConverterExp;
  }

  public WriteConverter getWriteConverter() {
    return writeConverter;
  }

  public void setWriteConverter(WriteConverter writeConverter) {
    this.writeConverter = writeConverter;
  }

  public String getReadConverterExp() {
    return readConverterExp;
  }

  public void setReadConverterExp(String readConverterExp) {
    this.readConverterExp = readConverterExp;
  }

  public ReadConverter getReadConverter() {
    return readConverter;
  }

  public void setReadConverter(ReadConverter readConverter) {
    this.readConverter = readConverter;
  }

  public String getRegularExp() {
    return regularExp;
  }

  public void setRegularExp(String regularExp) {
    this.regularExp = regularExp;
  }

  public String getRegularExpMessage() {
    return regularExpMessage;
  }

  public void setRegularExpMessage(String regularExpMessage) {
    this.regularExpMessage = regularExpMessage;
  }

  public Validator getValidator() {
    return validator;
  }

  public void setValidator(Validator validator) {
    this.validator = validator;
  }
}
