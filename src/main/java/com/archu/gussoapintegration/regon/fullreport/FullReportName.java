package com.archu.gussoapintegration.regon.fullreport;

public enum FullReportName {
    BIR11OsFizycznaDaneOgolne {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitOsFizycznaDaneOgolne(data);
        }
    },
    BIR11OsFizycznaDzialalnoscCeidg {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitOsFizycznaDzialalnoscCeidg(data);
        }
    },
    BIR11OsFizycznaDzialalnoscRolnicza {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitOsFizycznaDzialalnoscRolnicza(data);
        }
    },
    BIR11OsFizycznaDzialalnoscPozostala {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitOsFizycznaDzialalnoscPozostala(data);
        }
    },
    BIR11OsFizycznaDzialalnoscSkreslonaDo20141108 {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitOsFizycznaDzialalnoscSkreslonaDo20141108(data);
        }
    },
    BIR11OsFizycznaPkd {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitOsFizycznaPkd(data);
        }
    },
    BIR11OsFizycznaListaJednLokalnych {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitOsFizycznaListaJednLokalnych(data);
        }
    },
    BIR11JednLokalnaOsFizycznej {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitJednLokalnaOsFizycznej(data);
        }
    },
    BIR11JednLokalnaOsFizycznejPkd {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitJednLokalnaOsFizycznejPkd(data);
        }
    },
    BIR11OsPrawna {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitOsPrawna(data);
        }
    },
    BIR11OsPrawnaPkd {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitOsPrawnaPkd(data);
        }
    },
    BIR11OsPrawnaListaJednLokalnych {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitOsPrawnaListaJednLokalnych(data);
        }
    },
    BIR11JednLokalnaOsPrawnej {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitJednLokalnaOsPrawnej(data);
        }
    },
    BIR11JednLokalnaOsPrawnejPkd {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitJednLokalnaOsPrawnejPkd(data);
        }
    },
    BIR11OsPrawnaSpCywilnaWspolnicy {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitOsPrawnaSpCywilnaWspolnicy(data);
        }
    },
    BIR11TypPodmiotu {
        @Override
        public <T, J> T accept(FullReportVisitor<T, J> visitor, J data) {
            return visitor.visitTypPodmiotu(data);
        }
    };

    public abstract <T, J> T accept(FullReportVisitor<T, J> visitor, J data);

}
