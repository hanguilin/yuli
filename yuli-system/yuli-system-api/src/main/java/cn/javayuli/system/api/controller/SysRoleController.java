package cn.javayuli.system.api.controller;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.api.service.SysRoleService;
import cn.javayuli.system.ref.entity.SysRole;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色controller
 *
 * @author hanguilin
 */
@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 详情数据
     *
     * @param id 主键id
     * @return
     */
    @GetMapping("/info/{id}")
    public Rest<SysRole> doInfo(@PathVariable("id") String id) {
        return sysRoleService.getInfo(id);
    }

    /**
     * 保存数据
     *
     * @param sysRole 角色数据
     * @return
     */
    @PostMapping("/save")
    public Rest<Boolean> doSave(@RequestBody SysRole sysRole) {
        return sysRoleService.save(sysRole) ? Rest.success() : Rest.fail("保存失败");
    }

    /**
     * 更新数据
     *
     * @param sysRole 角色数据
     * @return
     */
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody SysRole sysRole) {
        return sysRoleService.updateById(sysRole) ? Rest.success() : Rest.fail("更新失败");
    }

    /**
     * 删除数据
     *
     * @param ids 主键id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping("/delete")
    public Rest<Boolean> doDelete (@RequestParam String ids) {
        List<String> idList = Splitter.on(",").splitToList(ids);
        return sysRoleService.removeByIds(idList) ? Rest.success() : Rest.fail("删除失败");
    }

    /**
     * 删除数据
     *
     * @param page 分页对象
     * @param sysRole 角色过滤
     * @return
     */
    @GetMapping("/page")
    public Rest<Page<SysRole>> doPage (Page page, SysRole sysRole) {
        return Rest.success(sysRoleService.page(page, Wrappers.query(sysRole)));
    }
}