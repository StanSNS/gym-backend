package gym.backend.consts;

public class EmailConst {
    public static final String TEST_TEMPLATE_HEAD = """
            <!DOCTYPE html>
            <html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" lang="bg-BG">
                    
            <head>
                <title></title>
                <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0"><!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]--><!--[if !mso]><!--><!--<![endif]-->
                <style>
                    * {
                        box-sizing: border-box;
                    }
                    
                    body {
                        margin: 0;
                        padding: 0;
                    }
                    
                    a[x-apple-data-detectors] {
                        color: inherit !important;
                        text-decoration: inherit !important;
                    }
                    
                    #MessageViewBody a {
                        color: inherit;
                        text-decoration: none;
                    }
                    
                    p {
                        line-height: inherit
                    }
                    
                    .desktop_hide,
                    .desktop_hide table {
                        mso-hide: all;
                        display: none;
                        max-height: 0px;
                        overflow: hidden;
                    }
                    
                    .image_block img+div {
                        display: none;
                    }
                    
                    @media (max-width:720px) {
                    
                        .desktop_hide table.icons-inner,
                        .social_block.desktop_hide .social-table {
                            display: inline-block !important;
                        }
                    
                        .icons-inner {
                            text-align: center;
                        }
                    
                        .icons-inner td {
                            margin: 0 auto;
                        }
                    
                        .mobile_hide {
                            display: none;
                        }
                    
                        .row-content {
                            width: 100% !important;
                        }
                    
                        .stack .column {
                            width: 100%;
                            display: block;
                        }
                    
                        .mobile_hide {
                            min-height: 0;
                            max-height: 0;
                            max-width: 0;
                            overflow: hidden;
                            font-size: 0px;
                        }
                    
                        .desktop_hide,
                        .desktop_hide table {
                            display: table !important;
                            max-height: none !important;
                        }
                    }
                </style>
            </head>
            """;

    public static final String TEST_TEMPLATE_BODY = """
            <body style="background-color: #f4f4f4; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;">
            <table class="nl-container" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f4f4f4; background-size: auto; background-image: none; background-position: top left; background-repeat: no-repeat;">
                <tbody>
                <tr>
                    <td>
                        <table class="row row-1" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="image_block block-1" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad" style="width:100%;padding-right:0px;padding-left:0px;">
                                                            <div class="alignment" align="center" style="line-height:10px">
                                                                <div style="max-width: 175px;"><img src="https://app-rsrc.getbee.io/public/resources/defaultrows/1.png" style="display: block; height: auto; border: 0; width: 100%;" width="175" alt="I'm an image" title="I'm an image" height="auto"></div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="text_block block-2" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="font-family: sans-serif">
                                                                <div class style="font-size: 12px; font-family: Arial, Helvetica, sans-serif; mso-line-height-alt: 14.399999999999999px; color: #555555; line-height: 1.2;">
                                                                    <p style="margin: 0; font-size: 16px; text-align: center; mso-line-height-alt: 19.2px; letter-spacing: normal;"><span style="font-size:42px;"><strong>Успешно направена поръчка</strong></span></p>
                                                                </div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <div class="spacer_block block-3" style="height:20px;line-height:20px;font-size:1px;">&#8202;</div>
                                                <table class="paragraph_block block-4" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:20px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:24px;">
                                                                <p style="margin: 0;"><strong>Благодарим ви, че избрахте нашата платформа. Вашата поръчка е успешно приета.<br>Подробностите за вашата поръчка са посочени по-долу:</strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <div class="spacer_block block-5" style="height:20px;line-height:20px;font-size:1px;">&#8202;</div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-2" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-size: auto;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-size: auto; background-color: #333; border-radius: 30px; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="heading_block block-1" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad">
                                                            <h1 style="margin: 0; color: #ffffff; direction: ltr; font-family: Arial, Helvetica, sans-serif; font-size: 30px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 36px;">Проследи своята поръчка с този номер</h1>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="heading_block block-2" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad">
                                                            <h1 style="margin: 0; color: #ffffff; direction: ltr; font-family: Arial, Helvetica, sans-serif; font-size: 30px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 36px;"><span style="color: #ff4500;">309484989302489</span></h1>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-3" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <div class="spacer_block block-1" style="height:20px;line-height:20px;font-size:1px;">&#8202;</div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-4" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #333; border-radius: 30px; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="33.333333333333336%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="image_block block-1" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad" style="width:100%;padding-right:0px;padding-left:0px;">
                                                            <div class="alignment" align="center" style="line-height:10px">
                                                                <div style="max-width: 233.333px;"><img src="https://app-rsrc.getbee.io/public/resources/defaultrows/placeholdersquare.png" style="display: block; height: auto; border: 0; width: 100%;" width="233.333" alt="I'm an image" title="I'm an image" height="auto"></div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td class="column column-2" width="66.66666666666667%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="paragraph_block block-1" width="100%" border="0" cellpadding="15" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:17px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:20.4px;">
                                                                <p style="margin: 0;"><span style="color: #ffffff;"><em><strong>Ultra Premium Whey Protein Build / Bag - EVERBUILD</strong></em></span></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-2" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Категория:</span>&nbsp;<span style="color: #ffffff;">асда асдас дас</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-3" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Тегло</span>:&nbsp;<span style="color: #ffffff;">2.270 кг.</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-4" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Вкус:</span>&nbsp;<span style="color: #ffffff;">Chocolate</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-5" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Цена:</span>&nbsp;2<span style="color: #ffffff;">58.85 лв.</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-6" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Брпй:</span> <span style="color: #ffffff;">5</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-5" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <div class="spacer_block block-1" style="height:20px;line-height:20px;font-size:1px;">&#8202;</div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-6" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #333; border-radius: 30px; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="33.333333333333336%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="image_block block-1" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad" style="width:100%;padding-right:0px;padding-left:0px;">
                                                            <div class="alignment" align="center" style="line-height:10px">
                                                                <div style="max-width: 233.333px;"><img src="https://app-rsrc.getbee.io/public/resources/defaultrows/placeholdersquare.png" style="display: block; height: auto; border: 0; width: 100%;" width="233.333" alt="I'm an image" title="I'm an image" height="auto"></div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td class="column column-2" width="66.66666666666667%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="paragraph_block block-1" width="100%" border="0" cellpadding="15" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:17px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:20.4px;">
                                                                <p style="margin: 0;"><span style="color: #ffffff;"><em><strong>Ultra Premium Whey Protein Build / Bag - EVERBUILD</strong></em></span></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-2" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Категория:</span>&nbsp;<span style="color: #ffffff;">асда асдас дас</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-3" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Тегло</span>:&nbsp;<span style="color: #ffffff;">2.270 кг.</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-4" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Вкус:</span>&nbsp;<span style="color: #ffffff;">Chocolate</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-5" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Цена:</span>&nbsp;2<span style="color: #ffffff;">58.85 лв.</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-6" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Брпй:</span> <span style="color: #ffffff;">5</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-7" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <div class="spacer_block block-1" style="height:20px;line-height:20px;font-size:1px;">&#8202;</div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-8" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #333; border-radius: 30px; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="33.333333333333336%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="image_block block-1" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad" style="width:100%;padding-right:0px;padding-left:0px;">
                                                            <div class="alignment" align="center" style="line-height:10px">
                                                                <div style="max-width: 233.333px;"><img src="https://app-rsrc.getbee.io/public/resources/defaultrows/placeholdersquare.png" style="display: block; height: auto; border: 0; width: 100%;" width="233.333" alt="I'm an image" title="I'm an image" height="auto"></div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td class="column column-2" width="66.66666666666667%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="paragraph_block block-1" width="100%" border="0" cellpadding="15" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:17px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:20.4px;">
                                                                <p style="margin: 0;"><span style="color: #ffffff;"><em><strong>Ultra Premium Whey Protein Build / Bag - EVERBUILD</strong></em></span></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-2" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Категория:</span>&nbsp;<span style="color: #ffffff;">асда асдас дас</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-3" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Тегло</span>:&nbsp;<span style="color: #ffffff;">2.270 кг.</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-4" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Вкус:</span>&nbsp;<span style="color: #ffffff;">Chocolate</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-5" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Цена:</span>&nbsp;2<span style="color: #ffffff;">58.85 лв.</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-6" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:16.8px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Брпй:</span> <span style="color: #ffffff;">5</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-9" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <div class="spacer_block block-1" style="height:20px;line-height:20px;font-size:1px;">&#8202;</div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-10" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #333; border-radius: 30px; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-left: 50px; padding-right: 50px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="heading_block block-1" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad">
                                                            <h1 style="margin: 0; color: #ffffff; direction: ltr; font-family: Arial, Helvetica, sans-serif; font-size: 30px; font-weight: 700; letter-spacing: normal; line-height: 150%; text-align: center; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 45px;">--- Информация за доставка ---</h1>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-2" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Име:&nbsp;</span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-3" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Фамилия: </span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-4" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Имейл: </span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-5" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Телефон: </span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-6" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Държава: </span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-7" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Град/село: </span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-8" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Пощенски код: </span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-9" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Куриерска фирма: </span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-10" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Вид на доставка: </span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-11" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Адрес: </span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-12" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Допълнителен адрес: </span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <div class="spacer_block block-13" style="height:20px;line-height:20px;font-size:1px;">&#8202;</div>
                                                <table class="heading_block block-14" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad">
                                                            <h1 style="margin: 0; color: #ffffff; direction: ltr; font-family: Arial, Helvetica, sans-serif; font-size: 31px; font-weight: 700; letter-spacing: normal; line-height: 150%; text-align: center; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 46.5px;"><span class="tinyMce-placeholder">--- Информация за поръчка&nbsp;---</span></h1>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-15" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Брой поръчани артикули: </span><span style="color: #ffffff;">9</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-16" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Тегло: </span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-17" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Доставка: </span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-18" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;">
                                                                <p style="margin: 0;"><strong><span style="color: #ff4500;">Дължима сума при доставка: </span><span style="color: #ffffff;">САДСАДСД</span></strong></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <div class="spacer_block block-19" style="height:20px;line-height:20px;font-size:1px;">&#8202;</div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-11" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <div class="spacer_block block-1" style="height:20px;line-height:20px;font-size:1px;">&#8202;</div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-12" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="paragraph_block block-1" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:20px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:24px;">
                                                                <p style="margin: 0;"><em><strong>Наш служител ще се свърже с вас скоро, за да потвърди поръчката и да ви предостави допълнителна информация, ако е необходимо.</strong></em></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="paragraph_block block-2" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="color:#101112;direction:ltr;font-family:Arial, Helvetica, sans-serif;font-size:20px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:24px;">
                                                                <p style="margin: 0;"><em><strong>Благодарим ви за доверието и избора на нашата компания. Ако имате някакви въпроси, не се колебайте да се свържете с нас.</strong></em></p>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-13" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <div class="spacer_block block-1" style="height:20px;line-height:20px;font-size:1px;">&#8202;</div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-14" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #333; border-radius: 0 0 30px 30px; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="50%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 10px; padding-top: 15px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="text_block block-1" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad" style="padding-bottom:10px;padding-left:40px;padding-right:10px;padding-top:10px;">
                                                            <div style="font-family: sans-serif">
                                                                <div class style="font-size: 12px; font-family: Arial, Helvetica, sans-serif; mso-line-height-alt: 18px; color: #ffffff; line-height: 1.5;">
                                                                    <p style="margin: 0; font-size: 18px; text-align: left; mso-line-height-alt: 27px;"><strong><span style="color:#ffffff;">Последвайте ни</span></strong></p>
                                                                </div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="text_block block-2" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad" style="padding-bottom:10px;padding-left:40px;padding-right:10px;padding-top:10px;">
                                                            <div style="font-family: sans-serif">
                                                                <div class style="font-size: 12px; font-family: Arial, Helvetica, sans-serif; mso-line-height-alt: 14.399999999999999px; color: #C0C0C0; line-height: 1.2;">
                                                                    <p style="margin: 0; font-size: 14px; text-align: left; mso-line-height-alt: 16.8px;"><span style="font-size:13px;">Бъдете в крак с текущите дейности и бъдещите събития, като ни последвате във вашите любими социални медии.</span></p>
                                                                </div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="html_block block-3" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad">
                                                            <div style="font-family:Arial, Helvetica, sans-serif;text-align:center;" align="center"><div style="height:20px;">&nbsp;</div></div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="social_block block-4" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                    <tr>
                                                        <td class="pad" style="padding-left:40px;text-align:center;padding-right:0px;">
                                                            <div class="alignment" align="center">
                                                                <table class="social-table" width="184px" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block;">
                                                                    <tr>
                                                                        <td style="padding:0 7px 0 7px;"><a href="https://www.facebook.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/facebook@2x.png" width="32" height="auto" alt="Facebook" title="Facebook" style="display: block; height: auto; border: 0;"></a></td>
                                                                        <td style="padding:0 7px 0 7px;"><a href="https://twitter.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/twitter@2x.png" width="32" height="auto" alt="Twitter" title="Twitter" style="display: block; height: auto; border: 0;"></a></td>
                                                                        <td style="padding:0 7px 0 7px;"><a href="https://plus.google.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/googleplus@2x.png" width="32" height="auto" alt="Google+" title="Google+" style="display: block; height: auto; border: 0;"></a></td>
                                                                        <td style="padding:0 7px 0 7px;"><a href="https://instagram.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/instagram@2x.png" width="32" height="auto" alt="Instagram" title="Instagram" style="display: block; height: auto; border: 0;"></a></td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <div class="spacer_block block-5" style="height:15px;line-height:15px;font-size:1px;">&#8202;</div>
                                            </td>
                                            <td class="column column-2" width="50%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <table class="text_block block-1" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                                                    <tr>
                                                        <td class="pad" style="padding-bottom:10px;padding-left:40px;padding-right:10px;padding-top:20px;">
                                                            <div style="font-family: sans-serif">
                                                                <div class style="font-size: 12px; font-family: Arial, Helvetica, sans-serif; mso-line-height-alt: 14.399999999999999px; color: #ffffff; line-height: 1.2;">
                                                                    <p style="margin: 0; font-size: 18px; text-align: left; mso-line-height-alt: 21.599999999999998px;"><strong><span style="color:#ffffff;">Свържи се с нас&nbsp;</span></strong></p>
                                                                </div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="icons_block block-2" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; text-align: left;">
                                                    <tr>
                                                        <td class="pad" style="vertical-align: middle; color: #ffffff; font-family: inherit; font-size: 14px; font-weight: 400; letter-spacing: 1px; padding-left: 40px; text-align: left;">
                                                            <table width="100%" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                                <tr>
                                                                    <td class="alignment" style="vertical-align: middle; text-align: left;"><!--[if vml]><table align="left" cellpadding="0" cellspacing="0" role="presentation" style="display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;"><![endif]-->
                                                                        <!--[if !vml]><!-->
                                                                        <table class="icons-inner" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;" cellpadding="0" cellspacing="0" role="presentation"><!--<![endif]-->
                                                                            <tr>
                                                                                <td style="vertical-align: middle; text-align: center; padding-top: 5px; padding-bottom: 5px; padding-left: 5px; padding-right: 5px;"><a href="sadasdasdsad" target="_self" style="text-decoration: none;"><img class="icon" alt="sdasasdasdasdsaasd" src="https://734277aedf.imgdist.com/pub/bfra/fxytxgp4/yl0/f01/euq/logo-gmail-email-gmail-gmail-1162901.jpg" height="auto" width="22" align="center" style="display: block; height: auto; margin: 0 auto; border: 0;"></a></td>
                                                                                <td style="font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: #ffffff; vertical-align: middle; letter-spacing: 1px; text-align: left;"><a href="sadasdasdsad" target="_self" style="color: #ffffff; text-decoration: none;">test@gmail.com</a></td>
                                                                            </tr>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <table class="icons_block block-3" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; text-align: left;">
                                                    <tr>
                                                        <td class="pad" style="vertical-align: middle; color: #ffffff; font-family: inherit; font-size: 14px; font-weight: 400; letter-spacing: 1px; padding-left: 40px; text-align: left;">
                                                            <table width="100%" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                                                                <tr>
                                                                    <td class="alignment" style="vertical-align: middle; text-align: left;"><!--[if vml]><table align="left" cellpadding="0" cellspacing="0" role="presentation" style="display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;"><![endif]-->
                                                                        <!--[if !vml]><!-->
                                                                        <table class="icons-inner" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;" cellpadding="0" cellspacing="0" role="presentation"><!--<![endif]-->
                                                                            <tr>
                                                                                <td style="vertical-align: middle; text-align: center; padding-top: 10px; padding-bottom: 10px; padding-left: 10px; padding-right: 10px;"><a href="sadasdasdsad" target="_self" style="text-decoration: none;"><img class="icon" alt="sdasasdasdasdsaasd" src="https://734277aedf.imgdist.com/pub/bfra/fxytxgp4/6p2/y5c/wsi/telephone-call-old-phone-telephone-8359678.jpg" height="auto" width="12" align="center" style="display: block; height: auto; margin: 0 auto; border: 0;"></a></td>
                                                                                <td style="font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: #ffffff; vertical-align: middle; letter-spacing: 1px; text-align: left;"><a href="sadasdasdsad" target="_self" style="color: #ffffff; text-decoration: none;">+358489465156</a></td>
                                                                            </tr>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="row row-15" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-radius: 0; color: #000000; width: 700px; margin: 0 auto;" width="700">
                                        <tbody>
                                        <tr>
                                            <td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                                                <div class="spacer_block block-1" style="height:30px;line-height:30px;font-size:1px;">&#8202;</div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
            </body>
                    
            </html>
            """;
}
