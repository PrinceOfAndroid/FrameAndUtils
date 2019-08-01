
package ${packageName};
import android.os.Bundle;
import com.base.baselib.base.mvp.MvpBaseActivity;
<#if applicationPackage??>
import ${applicationPackage}.R;
</#if>

public class ${ActivityName} extends MvpBaseActivity<${PresenterName}> implements ${IContractName}.${IViewName} {
    @Override
    protected ${PresenterName} buildPresenter() {
        return new ${PresenterName}();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_${activity_layout};
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initEventLoadData() {

    }


}

