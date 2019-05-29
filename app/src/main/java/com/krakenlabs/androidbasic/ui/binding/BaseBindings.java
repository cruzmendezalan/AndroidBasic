package com.krakenlabs.androidbasic.ui.binding;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;
import com.krakenlabs.androidbasic.commons.Constants;

import java.util.List;
import java.util.Set;

/**
 * Created by Alan Giovani Cruz Méndez on 2019-05-29 12:22.
 * cruzmendezalan@gmail.com
 */
public class BaseBindings {
    private static final String TAG = "WMBindings";

//    @BindingAdapter({"app:stores", "app:model"})
//    public static <T extends Object> void setStores(final AppCompatSpinner spinner, final List<T> items, final Address address){
//        if (items == null ){
//            return;
//        }
//
//        Class c = String.class;
//
//        String [] array = new String[items.size()];
//        if (items.size() > 0){
//            if (items.get(0) instanceof WMStore){
//
//                c = WMStore.class;
//
//                List<WMStore> stores = (List<WMStore>) items;
//                for (WMStore s:
//                  stores) {
//                    array[items.indexOf(s)] = s.getStoreName();
//                }
//            }else if(items.get(0) instanceof Colony){
//                c = Colony.class;
//                List<Colony> colonies = (List<Colony>) items;
//                for (Colony s:
//                  colonies) {
//                    array[items.indexOf(s)] = s.getColonyName();
//                }
//            } else{
//                for (T item:
//                  items) {
//                    array[items.indexOf(item)] = item.toString();
//                }
//            }
//        }
//
//
//
//        ArrayAdapter<String> itemsAdapter
//          = new ArrayAdapter<>
//          (
//            spinner.getContext(),
//            android.R.layout.simple_list_item_1,
//            array
//          );
//
//        itemsAdapter.setDropDownViewResource(
//          android
//            .R
//            .layout
//            .simple_spinner_dropdown_item);
//
//        spinner.setAdapter(itemsAdapter);
//
//        final Class finalC = c;
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (finalC == Colony.class){
//                    address.setColony((String) spinner.getSelectedItem());
//                    Colony colony = (Colony) items.get(spinner.getSelectedItemPosition());
//                    address.setNeighborhoodId(colony.getColonyId());
//                }else {
//                    address.setStoreName((String) spinner.getSelectedItem());
//                    address.setStore((WMStore) items.get(spinner.getSelectedItemPosition()));
//                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//    }
//
//    @BindingAdapter("app:note")
//    public static void setNote(ImageView imageView, String note){
//        if(note != null && !note.isEmpty()) {
//            imageView.setColorFilter(imageView.getResources().getColor(R.color.blue_default));
//        }else {
//            imageView.setColorFilter(imageView.getResources().getColor(R.color.gray_default));
//        }
//    }

//    @BindingAdapter("app:quantity")
//    public static void setQuantity(PiecesSelector piecesSelector, int quantity){
//        piecesSelector.setActualQuantity(quantity);
//    }

//    @BindingAdapter({"app:product", "app:notifier"})
//    public static void bindPiecesSelector(PiecesSelector piecesSelector, final Product product, final WMUIEvent event){
//        Log.d(TAG, "bindPiecesSelector() called with: piecesSelector = [" + piecesSelector + "], product = [" + product + "], event = [" + event + "]");
//
//        if (piecesSelector == null){
//            return;
//        }
//
//        if (product == null){
//            return;
//        }
//
//        if (event == null){
//            return;
//        }
//
//        piecesSelector.setPiecesSelectorEvent(new PiecesSelector.PiecesSelectorEvent() {
//            @Override
//            public void eventInSelector(int newQuantity, String baseUOM, String upc, PiecesSelector.PiecesSelectorEventType type) {
//                if (type.equals(PiecesSelector.PiecesSelectorEventType.ADD)){
//                    event.event(UIEventType.ADDTOCART, new WMUIObject().setData(product));
//                }else if (type.equals(PiecesSelector.PiecesSelectorEventType.UPDATE)){
//                    event.event(UIEventType.UPDATECART, new WMUIObject().setData(product));
//                }else if (type.equals(PiecesSelector.PiecesSelectorEventType.DELETE)){
//                    event.event(UIEventType.DELETECART,  new WMUIObject().setData(product));
//                }
//            }
//        });
//    }

//    @BindingAdapter("app:imgurl")
//    public static void bindImage(@NonNull ImageView imageView, Product product){
//        if (product != null && product.getImages() != null){
//            Picasso.with(imageView.getContext())
//              .load(product.getImages().get(0))
//              .into(imageView);
//        }
//    }
//
//    @BindingAdapter("app:img")
//    public static void bindImage(@NonNull ImageView imageView, String path){
//        try{
//            if (path != null){
//                Picasso.with(imageView.getContext())
//                  .load(path)
//                  .into(imageView);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    @BindingAdapter("app:price")
    public static void drawPrice(TextView textView, double price){
//        textView.setText(Constants.pricesFormat(price));
    }

    @BindingAdapter({"app:validation", "app:errorMsg"})
    public static void setErrorEnabled(final TextInputLayout textInputLayout, final StringRule stringRule, final String errorMsg) {
        textInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                    textInputLayout.setErrorEnabled(stringRule.validate(textInputLayout.getEditText().getText()));
                    if (stringRule.validate(textInputLayout.getEditText().getText())) {
                        textInputLayout.setError(errorMsg);
                    } else {
                        textInputLayout.setError(null);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        if (textInputLayout.hasFocus()){
            try{
                textInputLayout.setErrorEnabled(stringRule.validate(textInputLayout.getEditText().getText()));
                if (stringRule.validate(textInputLayout.getEditText().getText())) {
                    textInputLayout.setError(errorMsg);
                } else {
                    textInputLayout.setError(null);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    @BindingAdapter({"rvdata"})
    public static <T> void setRecyclerViewProperties(RecyclerView recyclerView, T model){
//        if (recyclerView.getAdapter() instanceof BindableAdapter<?>){
//            ((BindableAdapter)recyclerView.getAdapter()).setModel(model);
//        }
    }

    @BindingAdapter("updatePositions")
    public static <T> void setDataChanged(RecyclerView recyclerView, Set<T> positions){
//        if (recyclerView.getAdapter() instanceof BindableAdapter){
//            ((BindableAdapter)recyclerView.getAdapter()).changedPositions(positions);
//        }
    }

    public static class Rule {

        public static StringRule NOT_EMPTY_RULE = new StringRule() {
            @Override
            public boolean validate(Editable s) {
                return TextUtils.isEmpty(s.toString());
            }
        };

        public static StringRule EMAIL_RULE = new StringRule() {
            @Override
            public boolean validate(Editable s) {
                return !s.toString().matches(Constants.RulesText.MAIL.toString());
            }
        };

        public static StringRule PASSWORD_RULE = new StringRule() {
            @Override
            public boolean validate(Editable s) {
                return !s.toString().matches(Constants.RulesText.PASS.toString());
            }
        };

        public static StringRule NAME_RULE = new StringRule() {
            @Override
            public boolean validate(Editable s) {
                return !s.toString().matches(Constants.RulesText.NAME.toString());
            }
        };

        public static StringRule VALID_ZIPCODE = new StringRule() {
            @Override
            public boolean validate(Editable s) {
                return !s.toString().matches(Constants.RulesText.VALID_ZIPCODE.toString());
            }
        };

        public static StringRule ALFANUMERIC = new StringRule() {
            @Override
            public boolean validate(Editable s) {
                return !s.toString().matches(Constants.RulesText.ALFANUMERIC.toString());
            }
        };

        public static StringRule PHONENUMBER = new StringRule() {
            @Override
            public boolean validate(Editable s) {
                return !s.toString().matches(Constants.RulesText.PHONENUMBER.toString());
            }
        };
    }

    public interface StringRule {
        boolean validate(Editable s);
    }
}
