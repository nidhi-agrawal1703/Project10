package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.BranchDTO;
import com.rays.form.BranchForm;
import com.rays.service.BranchServiceInt;

@RestController
@RequestMapping(value="Branch")
public class BranchCtl extends BaseCtl<BranchForm,BranchDTO,BranchServiceInt> {

}
