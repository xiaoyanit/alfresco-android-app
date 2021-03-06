/*******************************************************************************
 * Copyright (C) 2005-2012 Alfresco Software Limited.
 * 
 * This file is part of Alfresco Mobile for Android.
 * 
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
 ******************************************************************************/
package org.alfresco.mobile.android.application.fragments.browser;

import java.io.File;

import org.alfresco.mobile.android.api.model.Folder;
import org.alfresco.mobile.android.application.utils.ContentFileProgressImpl;
import org.alfresco.mobile.android.application.utils.SessionUtils;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AddContentDialogFragment extends CreateDocumentDialogFragment
{
    public AddContentDialogFragment()
    {
    }

    public static AddContentDialogFragment newInstance(Folder folder, File f, String MIMEType)
    {
        AddContentDialogFragment adf = new AddContentDialogFragment();
        adf.setArguments(createBundle(folder, new ContentFileProgressImpl(f, f.getName(), MIMEType)));
        return adf;
    }
    
    public static AddContentDialogFragment newInstance(Folder folder, File f)
    {
        AddContentDialogFragment adf = new AddContentDialogFragment();
        adf.setArguments(createBundle(folder, new ContentFileProgressImpl(f)));
        return adf;
    }

    public static AddContentDialogFragment newInstance(Folder folder)
    {
        AddContentDialogFragment adf = new AddContentDialogFragment();
        adf.setArguments(createBundle(folder));
        return adf;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        setRetainInstance(true);
        alfSession = SessionUtils.getSession(getActivity());
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        alfSession = SessionUtils.getSession(getActivity());
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    @Override
    public void onDestroyView()
    {
        if (getDialog() != null && getRetainInstance())
        {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override
    public void onDismiss(DialogInterface dialog)
    {
        super.onDismiss(dialog);
    }
}
