package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.InquiryDTO;
import com.rays.form.InquiryForm;
import com.rays.service.InquiryServiceInt;

@RestController
@RequestMapping(value="Inquiry")
public class InquiryCtl extends BaseCtl<InquiryForm,InquiryDTO,InquiryServiceInt>{

}
