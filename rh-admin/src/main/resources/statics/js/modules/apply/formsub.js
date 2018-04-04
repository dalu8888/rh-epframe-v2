$(function () {

});

var vm = new Vue({
    el:'#rrapp',
    data:{
        showList: true,
        title: "XX省企业技术中心评定表",
        gb:{
            gbName:null,
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },

        gbTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择行业代码",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#gbLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    // vm.dept.parentId = node[0].deptId;
                    vm.gb.gbName = node[0].name;

                    layer.close(index);
                }
            });
        },

        reload: function () {
            vm.showList = true;
        }
    }
});